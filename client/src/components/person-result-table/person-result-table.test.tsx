import { screen } from "@testing-library/react";
import { PersonResultTable } from "./person-result-table";
import { render } from "../../utils/test-utils";
import i18next from "i18next";

describe("PersonResultTable", () => {
  it("renders table headers correctly", () => {
    const persons = [
      {
        vorname: "John",
        nachname: "Doe",
        geschlecht: "m" as const,
        numberOfAnschriften: 2,
        numberOfKommunikationsadressen: 1,
        ibans: "1234",
      },
    ];

    render(<PersonResultTable persons={persons} />);

    expect(
      screen.getByText(i18next.t("personTable.tableHeaders.vorname"))
    ).toBeInTheDocument();
    expect(
      screen.getByText(i18next.t("personTable.tableHeaders.nachname"))
    ).toBeInTheDocument();
    expect(
      screen.getByText(i18next.t("personTable.tableHeaders.geschlecht"))
    ).toBeInTheDocument();
    expect(
      screen.getByText(i18next.t("personTable.tableHeaders.anzahlAnschriften"))
    ).toBeInTheDocument();
    expect(
      screen.getByText(
        i18next.t("personTable.tableHeaders.anzahlKommunikationsadressen")
      )
    ).toBeInTheDocument();
    expect(
      screen.getByText(i18next.t("personTable.tableHeaders.ibans"))
    ).toBeInTheDocument();
  });

  it("renders person data correctly", () => {
    const persons = [
      {
        vorname: "John",
        nachname: "Doe",
        geschlecht: "m" as const,
        numberOfAnschriften: 2,
        numberOfKommunikationsadressen: 1,
        ibans: "1234",
      },
    ];

    render(<PersonResultTable persons={persons} />);

    expect(screen.getByText("John")).toBeInTheDocument();
    expect(screen.getByText("Doe")).toBeInTheDocument();
    expect(screen.getByText("m")).toBeInTheDocument();
    expect(screen.getByText("2")).toBeInTheDocument();
    expect(screen.getByText("1")).toBeInTheDocument();
    expect(screen.getByText("1234")).toBeInTheDocument();
  });
});
