package org.datangapps.projectmanagement.infrastructure.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "project_invoice")
@Data
public class ProjectInvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;

    @Column(name = "project_id", nullable = false)
    private UUID projectId;

    @Column(name = "invoice_number", length = 30, nullable = false)
    private String invoiceNumber;

    @Column(name = "invoice_date", nullable = false)
    private Date invoiceDate;

    @Column(name = "notes", length = 50)
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "created_by")
    private UUID createdBy;

    @Column(name = "updated_by")
    private UUID updatedBy;
}
