import { screen, fireEvent, waitFor } from "@testing-library/react";
import { FormContainer } from "./form-container";
import { fetcher } from "../../utils/fetch";
import { MockedFunction } from "jest-mock";
import i18next from "i18next";
import { render } from "../../utils/test-utils";

jest.mock("../../utils/fetch");

const mockFetcherGet = fetcher.get as MockedFunction<typeof fetcher.get>;

describe("FormContainer", () => {
  beforeEach(() => {
    jest.clearAllMocks();
  });

  it("renders the form and info alert", () => {
    render(<FormContainer />);

    expect(screen.getByRole("alert")).toHaveTextContent(
      i18next.t("personSearch.info")
    );
    expect(
      screen.getByLabelText(i18next.t("personSearch.formFields.vorname"))
    ).toBeInTheDocument();
    expect(
      screen.getByLabelText(i18next.t("personSearch.formFields.nachname"))
    ).toBeInTheDocument();
    expect(
      screen.getByLabelText(i18next.t("personSearch.formFields.iban"))
    ).toBeInTheDocument();
    expect(
      screen.getByLabelText(i18next.t("personSearch.formFields.email"))
    ).toBeInTheDocument();
    expect(
      screen.getByRole("button", { name: i18next.t("personSearch.submit") })
    ).toBeInTheDocument();
  });

  it("displays error message when no persons are found", async () => {
    mockFetcherGet.mockRejectedValueOnce({
      response: { status: 404 },
    });

    render(<FormContainer />);

    fireEvent.input(
      screen.getByLabelText(i18next.t("personSearch.formFields.vorname")),
      {
        target: { value: "Unknown" },
      }
    );
    fireEvent.click(
      screen.getByRole("button", { name: i18next.t("personSearch.submit") })
    );

    await waitFor(() => {
      expect(
        screen.getByText(i18next.t("personSearch.errors.notFound"))
      ).toBeInTheDocument();
    });
  });

  it("displays results when persons are found", async () => {
    const mockPersons: Person[] = [
      {
        vorname: "John",
        nachname: "Doe",
        geschlecht: "m",
        numberOfAnschriften: 2,
        numberOfKommunikationsadressen: 1,
        ibans: "1234",
      },
    ];

    mockFetcherGet.mockResolvedValueOnce(mockPersons);

    render(<FormContainer />);

    fireEvent.input(
      screen.getByLabelText(i18next.t("personSearch.formFields.vorname")),
      {
        target: { value: "John" },
      }
    );
    fireEvent.click(
      screen.getByRole("button", { name: i18next.t("personSearch.submit") })
    );

    await waitFor(() => {
      expect(
        screen.getByText(i18next.t("personSearch.results"))
      ).toBeInTheDocument();
      expect(screen.getByText("John")).toBeInTheDocument();
      expect(screen.getByText("Doe")).toBeInTheDocument();
      expect(screen.getByText("2")).toBeInTheDocument();
      expect(screen.getByText("1")).toBeInTheDocument();
      expect(screen.getByText("1234")).toBeInTheDocument();
    });
  });

  it("displays general error message on other errors", async () => {
    mockFetcherGet.mockRejectedValueOnce(new Error("Network Error"));

    render(<FormContainer />);

    fireEvent.input(
      screen.getByLabelText(i18next.t("personSearch.formFields.vorname")),
      {
        target: { value: "John" },
      }
    );
    fireEvent.click(
      screen.getByRole("button", { name: i18next.t("personSearch.submit") })
    );

    await waitFor(() => {
      expect(
        screen.getByText(i18next.t("personSearch.errors.general"))
      ).toBeInTheDocument();
    });
  });
});
