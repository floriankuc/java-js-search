import React, { ReactElement } from "react";
import { render, RenderOptions } from "@testing-library/react";
import { I18nextProvider } from "react-i18next";
import i18next from "../i18n/translations/i18n";

function AllTheProviders({ children }: { children: React.ReactNode }) {
  return <I18nextProvider i18n={i18next}>{children}</I18nextProvider>;
}

function customRender(
  ui: ReactElement,
  options?: Omit<RenderOptions, "wrapper">
) {
  return render(ui, { wrapper: AllTheProviders, ...options });
}

export * from "@testing-library/react";
export { customRender as render };
