package com.vbashur.guardian;

import com.vbashur.guardian.model.UserDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDao, Integer> {

    UserDao findByUsername(String username);
}
