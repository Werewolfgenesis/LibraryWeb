export interface Book {
  isbn: string;
  title: string;
  author: string;
  published: string;
  publisher: string;
  pages: number;
  description: string;
  genre: string;
}

export interface NewBook {
  isbn: string;
  title: string;
  author: string;
  genre: string;
}
