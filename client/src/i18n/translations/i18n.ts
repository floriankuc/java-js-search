import i18next from 'i18next';
import LanguageDetector from 'i18next-browser-languagedetector';
import { initReactI18next } from 'react-i18next';

import { de } from './de';

i18next
  .use(initReactI18next)
  .use(LanguageDetector)
  .init({
    lng: 'de',
    fallbackLng: 'de',
    resources: {
      de,
    },
    interpolation: {
      escapeValue: false,
    },
  });

export default i18next;