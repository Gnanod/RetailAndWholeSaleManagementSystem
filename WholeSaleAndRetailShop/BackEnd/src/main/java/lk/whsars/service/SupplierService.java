package lk.whsars.service;

import lk.whsars.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAgentBySupplier(String agentName);
}
