import { removeEmptyValues } from './helpers';

describe('removeEmptyParams', () => {
  it('should remove empty params', () => {
    const vorname = "John"

    const obj = {
      vorname,
      nachname: '',
      iban: '',
      email: ''
    }

    const result = removeEmptyValues(obj);
    expect(result).toEqual({ vorname });
  });
});