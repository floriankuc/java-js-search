import {de} from "../../src/i18n/translations/de";

describe('Searching for persons', () => {

  beforeEach(() => {
    cy.visit('/');
  });

  it('should render the app', () => {
    cy.get('h1').contains(de.translation.personSearch.headline);
  });

  it('should complete the form and submit', () => {
    // Fill out the form fields
    cy.get('input[name="vorname"]').type('Anton');
    cy.get('input[name="nachname"]').type('Schegolev');
    cy.get('input[name="iban"]').type('DE38500105172756356652');
    cy.get('input[name="email"]').type('anton.schegolev@gmail.com');

    // Submit the form
    cy.get('button[type="submit"]').click();

    // Confirm loading spinner is visible
    cy.get('.MuiCircularProgress-root').should('exist');

    // Verify the form submission
    cy.get('h2').contains(de.translation.personSearch.results);
    cy.get('table').should('be.visible');

    // Confirm loading spinner is gone
    cy.get('.MuiCircularProgress-root').should('not.exist');

    // Check if the table contains the "vorname"
    cy.get('table').contains('Anton');
  });

  it('should show a message if no person was found', () => {
    // Fill out the form fields
    cy.get('input[name="vorname"]').type('John');

    // Submit the form
    cy.get('button[type="submit"]').click();

    cy.get('.MuiCircularProgress-root').should('exist');

    // Verify the form submission
    cy.get('p').contains(de.translation.personSearch.errors.notFound);

    // Confirm loading spinner is visible
    cy.get('.MuiCircularProgress-root').should('not.exist');
  });
});