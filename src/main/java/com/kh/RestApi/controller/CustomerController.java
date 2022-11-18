//package com.kh.RestApi.controller;
//
//import com.kh.RestApi.dao.CustomerRepository;
//import com.kh.RestApi.entity.Customer;
//import org.hibernate.query.criteria.internal.expression.function.UpperFunction;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//
//public class CustomerController {
//    private CustomerRepository repository; // 내부의 필드 이름
//    public CustomerController(CustomerRepository repository) {
//        this.repository = repository;
//    }
//
//    @PostMapping("/customer") // 회원 데이터 생성(insert)
//    public Customer postCustomer(Customer customer) {
//        return repository.save(customer);
//    }
//
//    @PutMapping("/customer") // 회원 데이터 수정(update)
//    public Customer putCustomer(Customer customer) {
//        return repository.save(customer);
//    }
//
//    @DeleteMapping("/customer") // 회원 데이터 삭제(delete)
//    // return할 결과가 필요하지 않기 때문에 void
//    public void deleteCustomer(int id) {
//        repository.deleteById(id);
//    }
//
//    @GetMapping("/customer") // 회원 데이터 조회(select)
//    // id가지고 개별 조회
//    public Customer getCustomer(int id) {
//        return repository.findById(id).orElse(null); // 찾는 값이 없으면 null을 반환
//    }
//
//    @GetMapping("/customer/list") // 회원 데이터 조회(select)
//    // 전체 조회
//    public List<Customer> getCustomer() {
//        return repository.findAll();
//    }
//
//    @GetMapping("/customer/name") // 오버로딩 관계가 성립되기때문에 Customer 같이 쓸 수 있음
//    // 이름으로 정보 조회
//    public List<Customer> getCustomer(String name) {
//        return repository.findByName(name);
//    }
//
//    @GetMapping("/customer/address") // getCustomer 또 쓸 수 없음 => 변수명과 데이터 타입이 같기 때문
//    // 주소로 정보 조회
//    public List<Customer> getCustomerAddr(String address) {
//        return repository.findByAddressLike("%" + address + "%");
//    }
//
//    // Like 검색 해보기
//    @GetMapping("/customer/search")
//    public List<Customer> searchCustomer(String name) {
//        //return repository.findByNameLike("%" + name + "%");
//        return repository.findByNameLikeOrderByAddressDesc("%" + name + "%");
//    }
//
//    // 이름 또는 주소에 맞는 항목 검색하기
//    @GetMapping("/customer/name-addr")
//    public List<Customer> getCustomerNameAndAddr(String name, String address) {
//        return repository.findByNameAndAddress(name, address);
//    }
//
//    // Native 쿼리, JPQL 쿼리 호출
//    @GetMapping("/customer/name-addr-cust")
//    public List<Customer> getNativeNameAndAddr(String name, String address) {
//        // return repository.findVipList1(name, address); // Native 쿼리
//        return repository.findVipList2(name, address); // JPQL 쿼리
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
//
