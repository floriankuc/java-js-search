interface Person {
  vorname: string;
  nachname: string;
  ibans: string;
  numberOfKommunikationsadressen: number;
  numberOfAnschriften: number;
  geschlecht: Geschlecht;
}

type Geschlecht = "m" | "w" | "d" | "u" | "x";