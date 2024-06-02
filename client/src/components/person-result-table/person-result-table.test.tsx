import { render, screen } from "@testing-library/react";
import { PersonResultTable } from "./person-result-table";

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

    expect(screen.getByText("Vorname")).toBeInTheDocument();
    expect(screen.getByText("Nachname")).toBeInTheDocument();
    expect(screen.getByText("Geschlecht")).toBeInTheDocument();
    expect(screen.getByText("Anschriften")).toBeInTheDocument();
    expect(screen.getByText("Kommunikationsadressen")).toBeInTheDocument();
    expect(screen.getByText("IBANs")).toBeInTheDocument();
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
