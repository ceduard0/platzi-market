package com.olsoftware.platzimarket.persistence.crud;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.olsoftware.platzimarket.persistence.entity.Producto;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

	List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);

	Optional<List<Producto>> findBycantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
