package com.patika.springbootcamp.service;

import com.patika.springbootcamp.model.dto.ProductDTO;
import com.patika.springbootcamp.model.entity.Product;
import com.patika.springbootcamp.model.enums.*;
import com.patika.springbootcamp.model.mapper.ProductMapper;
import com.patika.springbootcamp.repository.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class) — Test sınıfları için kullanılan anotasyon.
//(Mockito’yu kullanacağımızı söyledik.)
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    //@Mock — Test edeceğimiz sınıfın bağımlılıklarını mocklamak yani taklit etmek için kullanılan anotasyon.
    @Spy
    private ProductRepository mockProductRepository;
    @Mock
    private ProductMapper mockProductMapper;

    //@InjectMocks — Mock nesnelerini test edeceğimiz sınıfa inject etmek için kullanılıyor.
    //Yani servise yukarıdaki mockları inject etmis oluyoruz..
    @InjectMocks
    private ProductService mockProductService;


    @Test
    void getAllProducts() {
        // given
        List<Product> products = getSampleTestProducts();
        //!!!!!!!!!!mapstruct bozuyor, düzelt!!!!!!!!!!
        List<ProductDTO> productDTOS = mockProductMapper.toProductDTOList(products);

        // stub - when
        when(mockProductRepository.findAll()).thenReturn(products);

        // then
        List<ProductDTO> allProducts = mockProductService.getAllProducts();

        Assert.assertEquals(products.size(), allProducts.size());

    }


    @Test
    void create_shouldCreateSuccessfully() {
        // given
        Product expected = new Product();
        expected.setId(null);

        // when
        Mockito.when(mockProductRepository.save(any())).thenReturn(expected);

        // then
        ProductDTO productDto = mockProductMapper.toProductDTO(expected);

        Product actual = mockProductService.create(productDto);

        //   verify(mockProductRepository, times(1)).save(expected);

        Assert.assertEquals(expected.getTitle(), actual.getTitle());
        Assert.assertEquals(expected.getDetails(), actual.getDetails());
        Assert.assertEquals(expected.getBrand(), actual.getBrand());

    }

    @Test
    void delete() {
        // init step
        Long productId = 1L;
        Product product = getSampleTestProducts().get(0);

        // stub - when step
        //  Mockito.when(mockProductRepository.getById(productId)).thenReturn(product);
        doNothing().when(mockProductRepository).deleteById(productId);

        // then - validate step
        mockProductService.delete(1L);

        verify(mockProductRepository, times(1)).deleteById(productId);

    }

    private List<Product> getSampleTestProducts() {
        List<Product> sampleList = new ArrayList<>();
        Product product = new Product(1L, "Pencil Case", "Unused", 5.9, 23, 90, "Eastpak", Usage.UNUSED, Size.ONE_SIZE, Colors.OTHER, Category.CHILD, SubCategory.BAGS, null
                , null);
        Product product2 = new Product(2L, "Book", "Used gently", 15.9, 100, 0, "Can Yayınları", Usage.UNUSED, Size.ONE_SIZE, Colors.OTHER, Category.HOME_LIVING, SubCategory.BOOKS, null, null);
        Product product3 = new Product(3L, "Chair", "Chair 3", 245.9, 200, 0, "IKEA", null, Size.ONE_SIZE, Colors.OTHER, Category.HOME_LIVING, SubCategory.HOBBY, null, null);
        sampleList.add(product2);
        sampleList.add(product);
        sampleList.add(product3);
        return sampleList;
    }

}