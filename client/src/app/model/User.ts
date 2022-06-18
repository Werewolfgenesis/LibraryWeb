import { Book } from './Book';

export interface User {
  username: string;
  password: string;
  books: Book[];
}
