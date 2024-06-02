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

interface PersonResultTableProps {
  persons: Person[];
}

const tableHeaders = {
  vorname: "Vorname",
  nachname: "Nachname",
  geschlecht: "Geschlecht",
  numberOfAnschriften: "Anschriften",
  numberOfKommunikationsadressen: "Kommunikationsadressen",
  ibans: "IBANs",
};

export const PersonResultTable: React.FC<PersonResultTableProps> = ({
  persons,
}) => {
  return (
    <TableContainer component={Paper}>
      <Table>
        <TableHead>
          <TableRow>
            {Object.values(tableHeaders).map((header, i) => (
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
};
