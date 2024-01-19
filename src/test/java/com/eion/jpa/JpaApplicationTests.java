package com.eion.jpa;

import com.eion.jpa.entity.Product;
import com.eion.jpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

@SpringBootTest

class JpaApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Iphone Phone");
		product.setPrice(1000d);
		productRepository.save(product);
	}

	@Test
	public void testRead() {
		Product product = productRepository.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());

	}

	@Test
	public void testUpdate() {
		Product product = productRepository.findById(1).get();
		product.setPrice(1200d);
		productRepository.save(product);
	}

	@Test
	public void testDelete() {
		if (productRepository.existsById(1)) {
			productRepository.deleteById(1);
		}

	}

	@Test
	public void testCount() {
		System.out.println("total records " + productRepository.count());

	}

	@Test
	public void testFindByName() {
		List<Product> products = productRepository.findByName("Iphone");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = productRepository.findByNameAndDesc("Iphone", "Phone");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = productRepository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByDescContains() {
		List<Product> products = productRepository.findByDescContains("Mobile");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<Product> products = productRepository.findByPriceBetween(2000d, 5000d);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByLiken() {
		List<Product> products = productRepository.findByDescLike("%Mobile%");
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindByIDs() {
		PageRequest pageRequest = PageRequest.of(1, 2);
		List<Product> products = productRepository
				.findByIdIn(Arrays.asList(1, 2, 3, 4), pageRequest);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllPaging() {
		PageRequest pageRequest = PageRequest.of(0, 2);
		Page<Product> products = productRepository.findAll(pageRequest);
		products.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllSorting() {
		PageRequest pageRequest = PageRequest.of(0, 4, Sort.by(Direction.DESC, "name"));
		productRepository.findAll(pageRequest)
				.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void findAllPagingAndSorting() {
		PageRequest pageRequest = PageRequest.of(0, 2, Direction.DESC, "name");
		productRepository.findAll(pageRequest)
				.forEach(p -> System.out.println(p.getName()));
	}

}
