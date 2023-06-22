package kz.springboot.springboot.finalTask.repository;

import kz.springboot.springboot.finalTask.model.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoldersRepository extends JpaRepository<Folders, Long> {
}
