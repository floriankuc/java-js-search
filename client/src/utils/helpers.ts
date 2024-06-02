export const removeEmptyValues = <T>(
  data: T
): Record<string, unknown> => {
  const params: Record<string, unknown> = {};
  for (const key in data) {
    if (data[key as keyof T]) {
      params[key] = data[key as keyof T];
    }
  }
  return params;
};