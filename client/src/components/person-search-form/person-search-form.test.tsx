import { fireEvent, renderHook, screen } from "@testing-library/react";
import { PersonSearchForm } from "./person-search-form";
import { Control, useForm } from "react-hook-form";
import { PersonSearchFormData } from "../../containers/form-container/form-container";
import i18next from "i18next";
import { render } from "../../utils/test-utils";

const { result } = renderHook(() => useForm());

const mockSubmit = jest.fn();
const mockClearErrors = jest.fn();

describe("PersonSearchForm", () => {
  it("renders all form fields", () => {
    render(
      <PersonSearchForm
        onSubmit={mockSubmit}
        control={
          result.current.control as unknown as Control<
            PersonSearchFormData,
            unknown
          >
        }
        errors={{}}
        clearErrors={mockClearErrors}
        isDirty={false}
        disabled={false}
      />
    );

    expect(
      screen.getByLabelText(i18next.t("personSearch.formFields.vorname"))
    ).toBeInTheDocument();
    expect(
      screen.getByLabelText(i18next.t("personSearch.formFields.nachname"))
    ).toBeInTheDocument();
    expect(
      screen.getByLabelText(i18next.t("personSearch.formFields.email"))
    ).toBeInTheDocument();
    expect(
      screen.getByLabelText(i18next.t("personSearch.formFields.iban"))
    ).toBeInTheDocument();
  });

  it("disables submit button when form has errors", () => {
    render(
      <PersonSearchForm
        onSubmit={mockSubmit}
        control={
          result.current.control as unknown as Control<
            PersonSearchFormData,
            unknown
          >
        }
        errors={{ email: { message: "Test", type: "pattern" } }}
        clearErrors={() => {}}
        isDirty={false}
        disabled={false}
      />
    );

    const submitButton = screen.getByText(i18next.t("personSearch.submit"));

    expect(submitButton).toBeDisabled();
  });

  it("disables submit button when form is not dirty", () => {
    render(
      <PersonSearchForm
        onSubmit={mockSubmit}
        control={
          result.current.control as unknown as Control<
            PersonSearchFormData,
            unknown
          >
        }
        errors={{}}
        clearErrors={mockClearErrors}
        isDirty={false}
        disabled={false}
      />
    );

    const submitButton = screen.getByText(i18next.t("personSearch.submit"));

    expect(submitButton).toBeDisabled();
  });

  it("calls onSubmit function with form data when submitted", () => {
    render(
      <PersonSearchForm
        onSubmit={mockSubmit}
        control={
          result.current.control as unknown as Control<
            PersonSearchFormData,
            unknown
          >
        }
        errors={{}}
        clearErrors={mockClearErrors}
        isDirty={true}
        disabled={false}
      />
    );

    fireEvent.change(
      screen.getByLabelText(i18next.t("personSearch.formFields.vorname")),
      {
        target: { value: "John" },
      }
    );
    fireEvent.change(
      screen.getByLabelText(i18next.t("personSearch.formFields.nachname")),
      {
        target: { value: "Doe" },
      }
    );
    fireEvent.change(
      screen.getByLabelText(i18next.t("personSearch.formFields.email")),
      {
        target: { value: "john@example.com" },
      }
    );
    fireEvent.change(
      screen.getByLabelText(i18next.t("personSearch.formFields.iban")),
      {
        target: { value: "DE89370400440532013000" },
      }
    );

    fireEvent.click(screen.getByText(i18next.t("personSearch.submit")));

    expect(mockSubmit).toHaveBeenCalledTimes(1);
  });
});
