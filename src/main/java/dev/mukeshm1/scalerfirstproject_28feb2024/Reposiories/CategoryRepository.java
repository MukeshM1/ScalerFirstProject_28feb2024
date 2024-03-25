package dev.mukeshm1.scalerfirstproject_28feb2024.Reposiories;

import dev.mukeshm1.scalerfirstproject_28feb2024.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String title);
    Category save(Category category);
}
