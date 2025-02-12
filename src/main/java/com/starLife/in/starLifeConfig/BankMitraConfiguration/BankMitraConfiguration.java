// package com.starLife.in.starLifeConfig.BankMitraConfiguration;


// import java.util.Arrays;
// import java.util.Collections;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// import com.starLife.in.repository.BankMitraRepository;


// @Configuration
// public class BankMitraConfiguration {
  
// @Autowired
// private CustomBankMitraDetailsService gettuserDetailsService;

// @Autowired private BankMitraRepository bankMitraRepo;



// @Bean 
// public SecurityFilterChain bankFilterChain(HttpSecurity http) throws Exception{


// //   cors maintain .....................................


// UrlBasedCorsConfigurationSource source = new
// 		UrlBasedCorsConfigurationSource();
// 		CorsConfiguration cfg = new CorsConfiguration();
// 		cfg.setAllowedOrigins(Arrays.asList(
// 		"http://localhost:9191",
// 		"http://localhost:5173"));
// 		cfg.setAllowCredentials(true);
// 		cfg.setAllowedHeaders(Collections.singletonList("*"));
// 		cfg.setAllowedMethods(Collections.singletonList("*"));
// 		cfg.setExposedHeaders(Arrays.asList("Authorization"));
// 		source.registerCorsConfiguration("/**", cfg);



//     //  now implement request matchers .........................

//     	http
// 				.csrf(Customizer -> Customizer.disable())

// 				// .addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class)
// 				.authorizeHttpRequests(request -> request
// 				.requestMatchers("/bank_mitra/**")
//         .authenticated()
// 				.anyRequest()
// 				.permitAll()
// 				)
//         .formLogin(login -> login
// 				.loginPage("/bankmitraLogin") // Specify the custom login page
// 				.loginProcessingUrl("/bankmitraDoLogin")
// 				.defaultSuccessUrl("/bank_mitra/dashboard" , true)
// 				.permitAll() 
// 				.failureUrl("/bank_mitra_register")
//         );

//         http.logout(logout -> logout

// 				.logoutUrl("/logout") // Custom logout URL
// 				.logoutSuccessUrl("/bankmitraLogin") // Redirect URL after successful logout
// 				.invalidateHttpSession(true) // Invalidate the session on logout
// 				.clearAuthentication(true) // Clear authentication
// 				.deleteCookies("JSESSIONID") // Optionally delete cookies
// 				.permitAll()
				
// 				);



//   return http.build();
  
// }



// 	@Bean
// 	public AuthenticationProvider authenticationProviderbank() {
// 		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
// 		provider.setPasswordEncoder(new BCryptPasswordEncoder());
// 		provider.setUserDetailsService(gettuserDetailsService);
// 		return provider;


//   }




// }
