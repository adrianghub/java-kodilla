package com.kodilla.good.patterns.challanges.suppliers;

public class Supplier implements SupplierProcessor {
    private InformationService informationService;
    private SupplierService supplierService;
    private SupplierRepository supplierRepository;

    public Supplier(InformationService informationService, SupplierService supplierService, SupplierRepository supplierRepository) {
        this.informationService = informationService;
        this.supplierService = supplierService;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplyDto process(final SupplierRequest supplierRequest) {
        boolean isOrderAvailable = supplierService.collectOrder(supplierRequest.getUser(), supplierRequest.getOrderDetails());

        if (isOrderAvailable) {
            supplierRepository.sendOrder(supplierRequest.getUser(), supplierRequest.getOrderDetails());
            informationService.sendConfirmationToClient((supplierRequest.getUser()));
            return new SupplyDto(supplierRequest.getUser(), true);
        } else {
            return new SupplyDto(supplierRequest.getUser(), false);
        }
    }
}
