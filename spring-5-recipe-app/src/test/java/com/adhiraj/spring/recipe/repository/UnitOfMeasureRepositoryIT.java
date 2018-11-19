package com.adhiraj.spring.recipe.repository;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import com.adhiraj.spring.recipe.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

  private final String unitOfMeasureTeaspoon = "Teaspoon";
  private final String unitOfMeasureCup = "Cup";

  @Autowired
  private UnitOfMeasureRepository unitOfMeasureRepository;

  @Mock
  private Model model;

  @Before
  public void setUp() throws Exception {}

  @Test
  // @DirtiesContext
  public void findByDescriptionTeaspoon() throws Exception {
    Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription(unitOfMeasureTeaspoon);

    Assert.assertEquals(unitOfMeasureTeaspoon, uom.get().getUom());
  }

  @Test
  public void findByDescriptionCup() throws Exception {
    Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription(unitOfMeasureCup);

    Assert.assertEquals(unitOfMeasureCup, uom.get().getUom());
  }

}
