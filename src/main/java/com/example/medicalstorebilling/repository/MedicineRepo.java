/**
 * 
 */
package com.example.medicalstorebilling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.medicalstorebilling.entity.Medicine;

import jakarta.transaction.Transactional;

/**
 * 
 */
@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Long> {

	@Query("SELECT m FROM Medicine m WHERE m.mName = :n")
	public List<Medicine> findByMName(@Param("n") String mName);
	
	/*
	 * @Query("SELECT m.quantity FROM Medicines m WHERE m.mName = :mName")
	 * Optional<Integer> findQntity(@Param("mName") String mName);
	 */
	@Query("SELECT m.quantity FROM Medicine m WHERE m.mName = :M")
    public int findQuantityByMName(@Param("M") String mName);
	
	@Modifying
    @Transactional
	@Query("Update Medicine m set m.quantity= :q where mName =:n")
	public void saveData(@Param("q") int quantity,@Param("n") String mName);

}
