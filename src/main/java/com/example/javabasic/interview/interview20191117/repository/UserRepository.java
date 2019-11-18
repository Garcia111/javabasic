package com.example.javabasic.interview.interview20191117.repository;

import com.example.javabasic.interview.interview20191117.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author：Cheng.
 * @date：Created in 10:48 2019/11/18
 */
@Repository
public interface UserRepository extends JpaSpecificationExecutor<UserEntity> ,
        JpaRepository<UserEntity,Long> {


}