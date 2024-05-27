package com.labbackend.labbackendx.repository;

import com.labbackend.labbackendx.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Object findByName(String s);
    // You can define custom query methods here if needed
}

