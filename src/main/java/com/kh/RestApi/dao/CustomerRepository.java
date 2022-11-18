package com.kh.RestApi.dao;

import com.kh.RestApi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository에 들어가면 쿼리문과 같은 기능을 하는 메소드들이 있음
// Integer(객체이름이기때문에!int가 아니라 Integer)는 ID가 int타입이기 때문에(프라이머리키의 타입이 들어가면 됨)
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByName(String name);
    List<Customer> findByAddressLike(String address);
    List<Customer> findByNameLike(String name);
    List<Customer> findByNameLikeOrderByAddressDesc(String name);
    List<Customer> findByNameOrAddress(String name, String address);
    List<Customer> findByNameAndAddress(String name, String address);


    // String sql = "SELECT * FROM PRO_TB WHERE PRO_KORNAME LIKE '%" + result + "%'OR UPPER(PRO_NAME) LIKE UPPER('%" + result + "%')OR UPPER(BRAND) LIKE UPPER('%" + result + "%')";
                                                                                                          
    // 명명 규칙으로 해결이 안되면 Native나 JPQL 쓰기(쿼리문 직접 날리기)
    // Native 쿼리 방법
    @Query(value = "select * from Customer where name = ?1 and address = ?2", nativeQuery = true)
    List<Customer> findVipList1(String name, String address);

    // JPQL(Java Persistence Query Language) 쿼리 방법
    @Query("from Customer where name = ?1 and address = ?2")
    List<Customer> findVipList2(String name, String address);
    
    // Native : 주소 검색창 구현
    @Query(value = "select * from Customer where address = ?1", nativeQuery = true)
    List<Customer> findVipList3(String address);
}
