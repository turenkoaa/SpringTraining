package com.db.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import static com.db.profiles.ProfilesConst.DEV;

@Repository
@Profile(DEV)
public class OneDao implements Dao {
    @Override
    public void saveAll() {
        System.out.println("One");
    }
}
