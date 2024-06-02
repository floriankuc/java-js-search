import { Button, TextField } from "@mui/material";
import React, { BaseSyntheticEvent } from "react";
import {
  Control,
  Controller,
  FieldErrors,
  UseFormClearErrors,
} from "react-hook-form";
import IBAN from "iban";
import { PersonSearchFormData } from "../../containers/form-container";

interface PersonSearchFormProps {
  onSubmit: (
    e: BaseSyntheticEvent<object, unknown, unknown> | undefined
  ) => Promise<void>;
  control: Control<PersonSearchFormData, unknown>;
  errors: FieldErrors<PersonSearchFormData>;
  clearErrors: UseFormClearErrors<PersonSearchFormData>;
  isDirty: boolean;
  disabled: boolean;
}

export const PersonSearchForm: React.FC<PersonSearchFormProps> = ({
  onSubmit,
  control,
  clearErrors,
  errors,
  isDirty,
  disabled,
}) => {
  return (
    <form onSubmit={onSubmit}>
      <Controller
        name="vorname"
        control={control}
        defaultValue=""
        disabled={disabled}
        rules={{
          pattern: {
            value: /^[a-zA-ZäöüÄÖÜß]+$/, // Include umlauts and ß
            message: "Vorname may only contain letters",
          },
        }}
        render={({ field, fieldState }) => (
          <TextField
            {...field}
            label="Vorname"
            variant="outlined"
            error={!!fieldState.error}
            helperText={fieldState.error ? fieldState.error.message : ""}
          />
        )}
      />
      <Controller
        name="nachname"
        control={control}
        defaultValue=""
        disabled={disabled}
        rules={{
          pattern: {
            value: /^[a-zA-ZäöüÄÖÜß]+$/,
            message: "Nachname may only contain letters",
          },
        }}
        render={({ field, fieldState }) => (
          <TextField
            {...field}
            label="Nachname"
            variant="outlined"
            error={!!fieldState.error}
            helperText={fieldState.error ? fieldState.error.message : ""}
          />
        )}
      />
      <Controller
        name="email"
        control={control}
        defaultValue=""
        disabled={disabled}
        rules={{
          pattern: {
            value: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/,
            message: "Invalid email address",
          },
        }}
        render={({ field, fieldState }) => (
          <TextField
            {...field}
            label="Email"
            variant="outlined"
            error={!!fieldState.error}
            helperText={fieldState.error ? fieldState.error.message : ""}
            onChange={(e) => {
              field.onChange(e);
              fieldState.error && clearErrors("email");
            }}
          />
        )}
      />

      <Controller
        name="iban"
        control={control}
        defaultValue=""
        disabled={disabled}
        rules={{
          validate: (value) => !value || IBAN.isValid(value) || "Invalid IBAN",
        }}
        render={({ field, fieldState }) => (
          <TextField
            {...field}
            label="IBAN"
            variant="outlined"
            error={!!fieldState.error}
            helperText={fieldState.error ? fieldState.error.message : ""}
            onChange={(e) => {
              field.onChange(e);
              fieldState.error && clearErrors("iban");
            }}
          />
        )}
      />
      <Button
        type="submit"
        variant="contained"
        disabled={disabled || !isDirty || !!Object.keys(errors).length}
      >
        Submit
      </Button>
    </form>
  );
};
