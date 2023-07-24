package com.br.songbox.repositories;

import com.br.songbox.models.UserModel;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    public UserModel findByLogin(@NotBlank String login);
}
