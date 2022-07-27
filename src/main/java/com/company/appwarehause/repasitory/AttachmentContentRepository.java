package com.company.appwarehause.repasitory;

import com.company.appwarehause.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
    Optional<AttachmentContent> findByAttachmentId(Integer attachment_id);
}
