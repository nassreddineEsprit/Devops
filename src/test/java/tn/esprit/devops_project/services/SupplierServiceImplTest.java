package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SupplierServiceImplTest {

    @Mock
    SupplierRepository supplierRepository;
    @InjectMocks
    SupplierServiceImpl iSupplierService;
    Supplier supplier = new Supplier(1L, "222324", "abcdef", SupplierCategory.ORDINAIRE, null, null);
    List<Supplier> supplierList = new ArrayList<Supplier>() {
        {
            add(new Supplier(2L, "242526", "Entreprise1", SupplierCategory.CONVENTIONNE, null, null));
            add(new Supplier(3L, "262728", "Entreprise2", SupplierCategory.CONVENTIONNE, null, null));
            add(new Supplier(1L, "282930", "Entreprise3", SupplierCategory.CONVENTIONNE, null, null));
            add(new Supplier(1L, "303132", "Entreprise4", SupplierCategory.CONVENTIONNE, null, null));
            add(new Supplier(1L, "323334", "Entreprise4", SupplierCategory.CONVENTIONNE, null, null));
        }

    };


    @Test
    void retrieveAllSuppliers() {
        Mockito.when(supplierRepository.findAll()).thenReturn(supplierList);
        List<Supplier> suppliers = iSupplierService.retrieveAllSuppliers();
        Assertions.assertNotNull(suppliers);

    }
}