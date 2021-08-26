package com.lambdaschool.usermodel.services;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component //Spring will see this and will call this class whenever a user is modifying something
public class UserAuditing implements AuditorAware<String> {
  @Override
  public Optional<String> getCurrentAuditor() {
    String uname;
    uname = "SYSTEM";

    return Optional.of(uname);
  }
}
