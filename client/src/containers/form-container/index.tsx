import { FunctionComponentElement, useState } from "react";
import { useForm } from "react-hook-form";
import { PersonSearchForm } from "../../components/person-search-form/person-search-form";
import { PersonResultTable } from "../../components/person-result-table/person-result-table";
import { fetcher } from "../../utils/fetch";
import { Alert, CircularProgress } from "@mui/material";
import { AxiosError } from "axios";
import { removeEmptyValues } from "../../utils/helpers";

export interface PersonSearchFormData {
  vorname: string;
  nachname: string;
  iban: string;
  email: string;
}

export function FormContainer(): FunctionComponentElement<
  Record<string, never>
> {
  const {
    handleSubmit,
    control,
    clearErrors,
    formState: { errors, isDirty },
  } = useForm<PersonSearchFormData>({
    mode: "onBlur",
    defaultValues: {
      vorname: "",
      nachname: "",
      iban: "",
      email: "",
    },
  });

  const [persons, setPersons] = useState<Person[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const onSubmit = async (data: PersonSearchFormData): Promise<void> => {
    setLoading(true);
    setError(null);

    try {
      const response = await fetcher.get<Person[]>(
        "personen",
        removeEmptyValues<PersonSearchFormData>(data)
      );

      setPersons(response);
    } catch (error) {
      if ((error as AxiosError).response?.status === 404) {
        setError((error as AxiosError).message);
      } else {
        setError("An error occurred while searching for persons");
      }
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
      <Alert className="m-b-l" severity="info">
        Mindestens ein Feld muss ausgefüllt werden.
      </Alert>
      <PersonSearchForm
        errors={errors}
        onSubmit={handleSubmit(onSubmit)}
        control={control}
        clearErrors={clearErrors}
        isDirty={isDirty}
        disabled={loading}
      />
      {<p className="error">{error}</p>}
      {!error && loading && (
        <div className="flex-justify-center m-t-l">
          <CircularProgress size={80} />
        </div>
      )}
      {!error && !loading && persons.length > 0 && (
        <>
          <h2>Search results</h2>
          <PersonResultTable persons={persons} />
        </>
      )}
    </>
  );
}
