package com.olsoftware.platzimarket.persistence;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.olsoftware.platzimarket.domain.Product;
import com.olsoftware.platzimarket.domain.repository.ProductRepository;
import com.olsoftware.platzimarket.persistence.crud.ProductoCrudRepository;
import com.olsoftware.platzimarket.persistence.entity.Producto;
import com.olsoftware.platzimarket.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {
	@Autowired
	private ProductoCrudRepository productoCrudRepository;

	@Autowired
	private ProductMapper mapper;

	@Override
	public List<Product> getAll() {
		List<Producto> productos = (List<Producto>) this.productoCrudRepository.findAll();
		return mapper.toProducts(productos);
	}

	@Override
	public void delete(int idProducto) {
		productoCrudRepository.deleteById(idProducto);
	}

	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		List<Producto> productos = (List<Producto>) this.productoCrudRepository
				.findByIdCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		Optional<List<Producto>> productos = this.productoCrudRepository.findBycantidadStockLessThanAndEstado(quantity,
				true);
		return productos.map(prods -> mapper.toProducts(prods));
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		return this.productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
	}

	@Override
	public Product save(Product product) {
		return mapper.toProduct(this.productoCrudRepository.save(mapper.toProducto(product)));
	}

}
