package com.comit.modelo;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
