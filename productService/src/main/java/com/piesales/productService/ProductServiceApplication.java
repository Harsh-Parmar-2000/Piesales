package com.piesales.productService;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.piesales.productService.entities.Products;
import com.piesales.productService.repositories.ProductRepo;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication implements CommandLineRunner{
	@Autowired
	ProductRepo productRepo;
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Products> saveProducts = new ArrayList<>();
		Products p1 = new Products();
		p1.setId(1);
		p1.setProductCategory("Electronics");
		p1.setProductDescription("I am Fan");
		p1.setProductName("Fan");
		p1.setProductImage("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcR9BYEwjR3fAx30lVkO9w4hvrRFhodF5MRvp6YFxvHyc3-_v76AAQnMjG84mBo32aDpflLHXxgfeBVYGqbi72ybVf2TIDWnIFxaMkOx3Am01KZc1lp7IqIW9A&usqp=CAE");
		p1.setProductPrice(5000L);
		saveProducts.add(p1);

		Products p2 = new Products();
		p2.setId(2);
		p2.setProductCategory("Electronics");
		p2.setProductDescription("I am Washing Machine");
		p2.setProductName("Washing Machine");
		p2.setProductImage("https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSItWg2_okeE0xHb3K4XvQ0mOe0tQQ7C_wXfSpjKkk8MLVhbLm037tlc49HnFTpORQoLPUgSEOnkvGqdt1flfUUhQo5is5JTklHmB4WzeujTtjfKMeH0IV93Q&usqp=CAE");
		p2.setProductPrice(2000L);
		saveProducts.add(p2);

		Products p3 = new Products();
		p3.setId(3);
		p3.setProductCategory("Electronics");
		p3.setProductDescription("I am Laptop");
		p3.setProductName("Laptop");
		p3.setProductImage("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/MJQJ3?wid=2000&hei=2000&fmt=jpeg&qlt=90&.v=1714431680269");
		p3.setProductPrice(6000L);
		saveProducts.add(p3);

		Products p4 = new Products();
		p4.setId(4);
		p4.setProductCategory("Electronics");
		p4.setProductDescription("I am Locker");
		p4.setProductName("Locker");
		p4.setProductImage("https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQzdxyGevmCMqKnc_7BnVFVs_Z4TaGIps4S7bLeFwtmttHMOB168tuSCONz_V1cZjGFuGkflU9xfPQb0Ap_9cbuEFIICsXWkALVJER6XxKtO2M83Vb3xLEh&usqp=CAE");
		p4.setProductPrice(2000L);
		saveProducts.add(p4);
		
		Products p5 = new Products();
		p5.setId(5);
		p5.setProductCategory("Electronics");
		p5.setProductDescription("I am Fan");
		p5.setProductName("Fan");
		p5.setProductImage("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcR9BYEwjR3fAx30lVkO9w4hvrRFhodF5MRvp6YFxvHyc3-_v76AAQnMjG84mBo32aDpflLHXxgfeBVYGqbi72ybVf2TIDWnIFxaMkOx3Am01KZc1lp7IqIW9A&usqp=CAE");
		p5.setProductPrice(5000L);
		saveProducts.add(p5);

		Products p6 = new Products();
		p6.setId(6);
		p6.setProductCategory("Electronics");
		p6.setProductDescription("I am Washing Machine");
		p6.setProductName("Washing Machine");
		p6.setProductImage("https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSItWg2_okeE0xHb3K4XvQ0mOe0tQQ7C_wXfSpjKkk8MLVhbLm037tlc49HnFTpORQoLPUgSEOnkvGqdt1flfUUhQo5is5JTklHmB4WzeujTtjfKMeH0IV93Q&usqp=CAE");
		p6.setProductPrice(2000L);
		saveProducts.add(p6);

		Products p7 = new Products();
		p7.setId(7);
		p7.setProductCategory("Electronics");
		p7.setProductDescription("I am Laptop");
		p7.setProductName("Laptop");
		p7.setProductImage("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/MJQJ3?wid=2000&hei=2000&fmt=jpeg&qlt=90&.v=1714431680269");
		p7.setProductPrice(6000L);
		saveProducts.add(p7);

		Products p8 = new Products();
		p8.setId(8);
		p8.setProductCategory("Electronics");
		p8.setProductDescription("I am Locker");
		p8.setProductName("Locker");
		p8.setProductImage("https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQzdxyGevmCMqKnc_7BnVFVs_Z4TaGIps4S7bLeFwtmttHMOB168tuSCONz_V1cZjGFuGkflU9xfPQb0Ap_9cbuEFIICsXWkALVJER6XxKtO2M83Vb3xLEh&usqp=CAE");
		p8.setProductPrice(2000L);
		saveProducts.add(p8);

		Products p9 = new Products();
		p9.setId(9);
		p9.setProductCategory("Electronics");
		p9.setProductDescription("I am Fan");
		p9.setProductName("Fan");
		p9.setProductImage("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcR9BYEwjR3fAx30lVkO9w4hvrRFhodF5MRvp6YFxvHyc3-_v76AAQnMjG84mBo32aDpflLHXxgfeBVYGqbi72ybVf2TIDWnIFxaMkOx3Am01KZc1lp7IqIW9A&usqp=CAE");
		p9.setProductPrice(5000L);
		saveProducts.add(p9);

		Products p10 = new Products();
		p10.setId(10);
		p10.setProductCategory("Electronics");
		p10.setProductDescription("I am Washing Machine");
		p10.setProductName("Washing Machine");
		p10.setProductImage("https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSItWg2_okeE0xHb3K4XvQ0mOe0tQQ7C_wXfSpjKkk8MLVhbLm037tlc49HnFTpORQoLPUgSEOnkvGqdt1flfUUhQo5is5JTklHmB4WzeujTtjfKMeH0IV93Q&usqp=CAE");
		p10.setProductPrice(2000L);
		saveProducts.add(p10);

		Products p11 = new Products();
		p11.setId(11);
		p11.setProductCategory("Electronics");
		p11.setProductDescription("I am Laptop");
		p11.setProductName("Laptop");
		p11.setProductImage("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/MJQJ3?wid=2000&hei=2000&fmt=jpeg&qlt=90&.v=1714431680269");
		p11.setProductPrice(6000L);
		saveProducts.add(p11);

		Products p12 = new Products();
		p12.setId(12);
		p12.setProductCategory("Electronics");
		p12.setProductDescription("I am Locker");
		p12.setProductName("Locker");
		p12.setProductImage("https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQzdxyGevmCMqKnc_7BnVFVs_Z4TaGIps4S7bLeFwtmttHMOB168tuSCONz_V1cZjGFuGkflU9xfPQb0Ap_9cbuEFIICsXWkALVJER6XxKtO2M83Vb3xLEh&usqp=CAE");
		p12.setProductPrice(2000L);
		saveProducts.add(p12);

		this.productRepo.saveAll(saveProducts);

	}

}
