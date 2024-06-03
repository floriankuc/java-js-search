import React from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
} from "@mui/material";
import i18next from "i18next";

interface PersonResultTableProps {
  persons: Person[];
}

function personTableHeaders(): Record<keyof Person, string> {
  return {
    vorname: i18next.t("personTable.tableHeaders.vorname"),
    nachname: i18next.t("personTable.tableHeaders.nachname"),
    geschlecht: i18next.t("personTable.tableHeaders.geschlecht"),
    numberOfAnschriften: i18next.t(
      "personTable.tableHeaders.anzahlAnschriften"
    ),
    numberOfKommunikationsadressen: i18next.t(
      "personTable.tableHeaders.anzahlKommunikationsadressen"
    ),
    ibans: i18next.t("personTable.tableHeaders.ibans"),
  };
}

export function PersonResultTable({
  persons,
}: PersonResultTableProps): React.FunctionComponentElement<
  React.FC<PersonResultTableProps>
> {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            {Object.values(personTableHeaders()).map((header, i) => (
              <TableCell key={i}>{header}</TableCell>
            ))}
          </TableRow>
        </TableHead>
        <TableBody>
          {persons.map(
            (
              {
                vorname,
                nachname,
                geschlecht,
                numberOfAnschriften,
                numberOfKommunikationsadressen,
                ibans,
              },
              i
            ) => (
              <TableRow key={i}>
                <TableCell>{vorname}</TableCell>
                <TableCell>{nachname}</TableCell>
                <TableCell>{geschlecht}</TableCell>
                <TableCell>{numberOfAnschriften}</TableCell>
                <TableCell>{numberOfKommunikationsadressen}</TableCell>
                <TableCell>{ibans}</TableCell>
              </TableRow>
            )
          )}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
