import { fireEvent, render, renderHook, screen } from "@testing-library/react";
import { PersonSearchForm } from "./person-search-form";
import { Control, useForm } from "react-hook-form";
import { PersonSearchFormData } from "../../containers/form-container";

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

    expect(screen.getByLabelText("Vorname")).toBeInTheDocument();
    expect(screen.getByLabelText("Nachname")).toBeInTheDocument();
    expect(screen.getByLabelText("Email")).toBeInTheDocument();
    expect(screen.getByLabelText("IBAN")).toBeInTheDocument();
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
        errors={{ email: { message: "Email is required", type: "required" } }}
        clearErrors={() => {}}
        isDirty={false}
        disabled={false}
      />
    );

    const submitButton = screen.getByText("Submit");

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

    const submitButton = screen.getByText("Submit");

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

    fireEvent.change(screen.getByLabelText("Vorname"), {
      target: { value: "John" },
    });
    fireEvent.change(screen.getByLabelText("Nachname"), {
      target: { value: "Doe" },
    });
    fireEvent.change(screen.getByLabelText("Email"), {
      target: { value: "john@example.com" },
    });
    fireEvent.change(screen.getByLabelText("IBAN"), {
      target: { value: "DE89370400440532013000" },
    });

    fireEvent.click(screen.getByText("Submit"));

    expect(mockSubmit).toHaveBeenCalledTimes(1);
  });
});
