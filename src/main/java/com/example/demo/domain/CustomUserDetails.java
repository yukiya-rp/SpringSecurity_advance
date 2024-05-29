package com.example.demo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
  private final User user;
  private final Collection<GrantedAuthority> authorities;

  public CustomUserDetails(User user) {
    this.user = user;
    this.authorities = Collections.singletonList(new SimpleGrantedAuthority(user.role()));
  }

  // ユーザーに付与された権限を返す
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  // ユーザー名を返す
  @Override
  public String getUsername() {
    return user.username();
  }

  // ユーザーパスワードを返す
  @Override
  public String getPassword() {
    return user.password();
  }

  // アカウントが期限切れでないかを示す
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  // アカウントがロックされていないかを示す
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  // 資格情報が期限切れでないかを示す
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  // アカウントが有効かを示す
  @Override
  public boolean isEnabled() {
    return true;
  }
}
