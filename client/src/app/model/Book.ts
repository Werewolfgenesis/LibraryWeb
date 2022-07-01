import { Note } from "./Note";

export interface Book {
  isbn: string;
  title: string;
  author: string;
  genre: string;
  notes: Note[],
}
