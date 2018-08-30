package com.db.quoters.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

import static com.db.profiles.ProfilesConst.WITH_ASPECTS;

@Configuration
@Profile(WITH_ASPECTS)
@EnableAspectJAutoProxy
public class WithAspectConfig {
}
