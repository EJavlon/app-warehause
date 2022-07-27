package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
