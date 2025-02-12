// package com.starLife.in.starLifeConfig;

// import java.util.Collection;
// import java.util.Collections;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.starLife.in.Entity.BankMitra;

// public class BankMitraInfoDetails  implements UserDetails {
  
  
//   private BankMitra bankMitra;

//   private String username;
// 	private String password;
// 	private List<GrantedAuthority> authorities;

//   public BankMitraInfoDetails(BankMitra bankMitra){
//            this.bankMitra = bankMitra;
//   }


//   @Override
//   public Collection<? extends GrantedAuthority> getAuthorities() {
    
//     return Collections.singletonList(new SimpleGrantedAuthority(bankMitra.getRole()));
//   }

//   @Override
//   public String getPassword() {
//    return bankMitra.getPassword();
//   }

//   @Override
//   public String getUsername() {
//     return bankMitra.getEmail();
//   }


// 	@Override
// 	public boolean isAccountNonExpired() {
		
// 		return true;
// 	}

// 	@Override
// 	public boolean isAccountNonLocked() {
		
// 		return true;
// 	}

// 	@Override
// 	public boolean isCredentialsNonExpired() {
		
// 		return true;
// 	}

// 	@Override
// 	public boolean isEnabled() {
		
// 		return true;
// 	}


  
// }
