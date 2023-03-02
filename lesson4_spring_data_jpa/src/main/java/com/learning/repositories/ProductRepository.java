package com.learning.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.models.Product;

// Integer là kiểu của khóa chính

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

//	write JPAQL 
	@Query("from Product where status = :status")
	List<Product> condition1(@Param("status") boolean status);
	
	@Query("from Product where price >= :min and price <= :max")
	List<Product> condition2(@Param("min") double min, @Param("max") double max);
	
	@Query("from Product where name like %:keyword%")
	List<Product> like(@Param("keyword") String keyword);
	
	@Query("from Product where year(created) = :year")
	List<Product> findByYear(@Param("year") int year);
		
	@Query("from Product where year(created) = :year and month(created) = :month")
	List<Product> findByYearAndMonth(@Param("year") int yearm, @Param("month") int month);
	
	@Query("from Product where year(created) = :year and month(created) = :month and day(created) = :day")
	List<Product> findByYearAndMonthandDay(@Param("year") int yearm, @Param("month") int month, @Param("day") int day);
	
	@Query("from Product where created >= :start and created <= :end")
	List<Product> findByDates(@Param("start") Date start, @Param("end") Date end);
	
	@Query("from Product order by price desc")
	List<Product> sortPriceDesc(); 
	
	@Query("from Product where status = :status order by price desc")
	List<Product> sortWithCondition(@Param("status") boolean status);
	
	//=> use native query
	@Query(value = "select * from product order by id offset 0 rows fetch next :n rows only", nativeQuery = true)
	List<Product> limit1(@Param("n") int n);
	
	// bỏ qua start row và lấy n row  
	@Query(value = "select * from product order by id offset :start rows fetch next :n rows only;", nativeQuery = true)
	List<Product> limit2(@Param("start") int start, @Param("n") int n);
	
	@Query(value = "select * from product where status = :status order by id offset :start rows fetch next :n rows only;", nativeQuery = true)
	List<Product> limit3(@Param("status") boolean status, @Param("start") int start, @Param("n") int n);
	
	@Query("select count(id) from Product")
	long count2(@Param("status") boolean status);
	
	@Query("select sum(quantity) from Product")
	long sum1();
	
	@Query("select sum(price * quantity) from Product where status = :status")
	double sum2(@Param("status") boolean status);
	
	@Query("select min(price) from Product")
	double minPrice();
	
	@Query("select max(price) from Product")
	double maxPrice();
	
	@Query("select avg(price) from Product")
	double avgPrice();
	
	
//	Ajax lesson 5
	@Query("select name from Product where name like %:keyword%")
	List<String> searchByKeyword(@Param("keyword") String keywrod);
}
