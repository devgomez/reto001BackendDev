package com.reto001.app.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.reto001.app.dominio.customers;
import com.reto001.app.dominio.indicadores;

public interface customerRepository extends CrudRepository<customers, Long> {
	

    @Query("select p from customers p where (:dni is null or   p.dni like %:dni%) "
    		+ " and   (:email is null or p.email like %:email%)")
    List<customers> findByDniOrEmail(@Param("dni") String dni,@Param("email") String email);
    
    
    
    
    
    
    @Query(" select count(1) "
    		+ " from customers where  month(fecha_nacimiento) = :mes "
    		+ " and year(fecha_nacimiento)= :anio ")
    long cantidadNacidos(@Param("mes") Integer mes,@Param("anio") Integer anio);
    
    
    @Query( value="select totales.cantidad,totales.mes  from ( select  count(1) as cantidad, upper( monthname(c.fecha_nacimiento)) as mes  	from customers c  	where year(c.fecha_nacimiento)=:anio 	group by month(c.fecha_nacimiento) 	having count(1) = (		select max(table1.cantidad) 	from ( 	select  count(1) as cantidad, upper( monthname(cc.fecha_nacimiento)) as mes  		from customers cc where year(cc.fecha_nacimiento)=:anio 		group by monthname(cc.fecha_nacimiento) ) as table1) )  as totales;", nativeQuery = true)
    List<Map<String,Object>> getMesMayorNacimientos(@Param("anio") Integer anio);
    
    @Query( value="select totales.cantidad,totales.mes  from ( select  count(1) as cantidad, upper( monthname(c.fecha_nacimiento)) as mes  	from customers c  	where year(c.fecha_nacimiento)=:anio 	group by month(c.fecha_nacimiento) 	having count(1) = (		select min(table1.cantidad) 	from ( 	select  count(1) as cantidad, upper( monthname(cc.fecha_nacimiento)) as mes  		from customers cc where year(cc.fecha_nacimiento)=:anio 		group by monthname(cc.fecha_nacimiento) ) as table1) )  as totales;", nativeQuery = true)
    List<Map<String,Object>> getMesMenorNacimientos(@Param("anio") Integer anio);
    

}
