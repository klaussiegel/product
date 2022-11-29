package edu.klaus.product.business.bc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryBCTest {

    @Test
    void findAll() {
        CategoryBC categoryBC = new CategoryBC();
        assertNotNull(categoryBC);
    }
}