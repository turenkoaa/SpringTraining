package com.db.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import static com.db.profiles.ProfilesConst.PROD;

@Repository
@Profile(PROD)
public class TwoDao implements Dao {
    @Override
    public void saveAll() {
        System.out.println("two");
    }
}
