package com.management.kintaikanri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.kintaikanri.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

	@Query(value = "SELECT SHAIN_NO, PASS FROM MSSHAIN WHERE SHAIN_NO = :loginId", nativeQuery = true)
	LoginEntity findLoginInfo(@Param("loginId") int loginId);

}
