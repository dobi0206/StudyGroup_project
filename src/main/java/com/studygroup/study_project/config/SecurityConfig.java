package com.studygroup.study_project.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
//security 사용 annotation

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .cors(cors->cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authorizeHttpRequests(authz->authz.requestMatchers("/","/loginPage","/logout","/noticeCheckPage","/registerPage","/Notice/all","/projectPage")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST,"/login","/register").permitAll()
                        .requestMatchers("/resources/**","/WEB-INF/**").permitAll()
                        .requestMatchers("/noticeAddPage","/noticeModifypage").hasAnyAuthority("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/Notice/add").hasAnyAuthority("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/Notice/update").hasAnyAuthority("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/Notice/delete").hasAnyAuthority("MANAGER")
                        .anyRequest().authenticated()
                )
                // csrf , cors, session , 권한별 페이지 접속 가능 설정

                .formLogin(
                login-> login.loginPage("/loginPage")
                        .loginProcessingUrl("/login")
                        .failureUrl("/loginPage?error=true")
                        .usernameParameter("userID") // input 태그의 name
                        .passwordParameter("password") // input 태그의 name + input 태그의 name과 id의 차이점 알아보기
                        // id -> 고유한 식별 목적 , class -> css쿼리문 및 재사용 목적, name -> form 컨트롤러 요소의 값을 서버로 전송하기 위해 필요한 속성
                        .successHandler(authenticationSuccessHandler())
                        .permitAll()
                        )
                // 로그인 구현

                .logout(logout->logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃 URL을 통해서 진행
                        .logoutSuccessUrl("/") // 로그아웃 후 리다이렉팅
                        .invalidateHttpSession(true) // 세션 무효화
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();

    }

    // 패스워드 암호화
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new SimpleUrlAuthenticationSuccessHandler(){

            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                HttpSession session = request.getSession();
                boolean isManager = authentication.getAuthorities().stream()
                        .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("MANAGER"));
                if(isManager){
                    session.setAttribute("MANAGER",true);
                }
                session.setAttribute("userID",authentication.getName());
                session.setAttribute("isAuthenticated",true);
                response.sendRedirect(request.getContextPath()+"/");

                super.onAuthenticationSuccess(request, response, authentication);
            } // ID와 비밀번호 parameter를 저장하고, 권한이 manager이면 session에 저장하기
        };
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080","https://localhost:8080"));
     // cors는 정해진 서버만 데이터 이동 가능. 그래서 localhost:8080만 설정해놓은 것
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization","content-type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
